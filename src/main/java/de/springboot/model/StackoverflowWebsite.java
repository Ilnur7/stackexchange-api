package de.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StackoverflowWebsite {

    @Id
    private String id;
    private String website;
    private String iconImageUrl;
    private String title;
    private String description;

    public static StackoverflowWebsiteBuilder builder() {
        return new StackoverflowWebsiteBuilder();
    }

    public static class StackoverflowWebsiteBuilder {
        private String id;
        private String website;
        private String iconImageUrl;
        private String title;
        private String description;

        StackoverflowWebsiteBuilder() {
        }

        public StackoverflowWebsiteBuilder id(String id) {
            this.id = id;
            return this;
        }

        public StackoverflowWebsiteBuilder website(String website) {
            this.website = website;
            return this;
        }

        public StackoverflowWebsiteBuilder iconImageUrl(String iconImageUrl) {
            this.iconImageUrl = iconImageUrl;
            return this;
        }

        public StackoverflowWebsiteBuilder title(String title) {
            this.title = title;
            return this;
        }

        public StackoverflowWebsiteBuilder description(String description) {
            this.description = description;
            return this;
        }

        public StackoverflowWebsite build() {
            return new StackoverflowWebsite(id, website, iconImageUrl, title, description);
        }

        public String toString() {
            return "StackoverflowWebsite.StackoverflowWebsiteBuilder(id=" + this.id + ", website=" + this.website + ", iconImageUrl=" + this.iconImageUrl + ", title=" + this.title + ", description=" + this.description + ")";
        }
    }
}
