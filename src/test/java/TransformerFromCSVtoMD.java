import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class TransformerFromCSVtoMD {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java TransformerFromCSVtoMD <input_csv_file> <output_md_file>");
            System.out.println("Example: java TransformerFromCSVtoMD input.csv output.md");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            int rowCount = convertCSVToMarkdown(inputFilePath, outputFilePath);
            System.out.println("Successfully converted " + inputFilePath + " to " + outputFilePath);
            System.out.println("Total rows processed: " + rowCount);
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    public static int convertCSVToMarkdown(String csvFilePath, String mdFilePath) throws IOException {
        List<CSVRecord> records = new ArrayList<>();
        int columnCount;

        // Read all CSV records
        try (CSVParser parser = new CSVParser(new FileReader(csvFilePath),
                CSVFormat.DEFAULT.builder().setHeader().build())) {

            // Get headers
            List<String> headers = new ArrayList<>(parser.getHeaderNames());
            columnCount = headers.size();

            // Read all records
            for (CSVRecord record : parser) {
                records.add(record);
            }

            // Write to Markdown file
            try (FileWriter writer = new FileWriter(mdFilePath)) {
                // Write headers
                writer.write("| ");
                for (int i = 0; i < headers.size(); i++) {
                    writer.write(escapeMarkdownTableCell(headers.get(i)));
                    if (i < headers.size() - 1) {
                        writer.write(" | ");
                    }
                }
                writer.write(" |\n");

                // Write separator row
                writer.write("|");
                for (int i = 0; i < columnCount; i++) {
                    writer.write(" --- |");

                }
                writer.write("\n");

                // Write data rows
                for (CSVRecord record : records) {
                    writer.write("| ");


                    for (int i = 0; i < columnCount; i++) {
                        String cellValue = "";
                        if (i < record.size()) {
                            cellValue = record.get(i) != null ? record.get(i) : "";
                        }
                        writer.write(escapeMarkdownTableCell(cellValue));
                        if (i < columnCount - 1) {
                            writer.write(" | ");
                        }
                    }
                    writer.write(" |\n");
                }
            }
        }

        // Return the number of data rows processed (excluding header)
        return records.size();
    }

    /**
     * Escapes special characters in Markdown table cells
     */
    private static String escapeMarkdownTableCell(String text) {
        if (text == null) {
            return "";
        }

        return text.replace("|", "\\|")
                  .replace("\n", "<br>")
                  .replace("\r", "")
                  .trim();
    }
}
