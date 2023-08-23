package models;

import lombok.Data;

@Data
public class UserCreateUpdateRequest {
    private String name;
    private String job;

    public UserCreateUpdateRequest(String name, String job) {
    }

    public static class UserCreateUpdateRequestBuilder {
        private String name;
        private String job;


        UserCreateUpdateRequestBuilder() {
        }

        public static UserCreateUpdateRequestBuilder builder() {
            return new UserCreateUpdateRequestBuilder();
        }

        public UserCreateUpdateRequestBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserCreateUpdateRequestBuilder setJob(String job) {
            this.job = job;
            return this;
        }

        public UserCreateUpdateRequest build() {
            return new UserCreateUpdateRequest(this.name, this.job);
        }

    }
}


