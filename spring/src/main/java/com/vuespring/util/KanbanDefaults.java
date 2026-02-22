package com.vuespring.util;

import java.util.List;

public class KanbanDefaults {

    public static class DefaultColumnDTO {
        private String name;
        private int orderIndex;
        private String primaryColor;
        private String secondaryColor;
        private String backgroundColor;

        public DefaultColumnDTO(String name, int orderIndex, String primaryColor, String secondaryColor, String backgroundColor) {
            this.name = name;
            this.orderIndex = orderIndex;
            this.primaryColor = primaryColor;
            this.secondaryColor = secondaryColor;
            this.backgroundColor = backgroundColor;
        }
        public String getName() { return name; }
        public int getOrderIndex() { return orderIndex; }
        public String getPrimaryColor() { return primaryColor; }
        public String getSecondaryColor() { return secondaryColor; }
        public String getBackgroundColor() { return backgroundColor; }
    }

        public static final List<DefaultColumnDTO> DEFAULT_COLUMNS = List.of(
              new DefaultColumnDTO("Inbox", 0, "#6B7280", "#93C5FD", "#F3F4F6"),
              new DefaultColumnDTO("Qualified", 1, "#4B7F52", "#A7D7B5", "#ECF5EF"),
              new DefaultColumnDTO("Active", 2, "#1E3A8A", "#60A5FA", "#EFF6FF"),
              new DefaultColumnDTO("Proposal", 3, "#3730A3", "#A5B4FC", "#EEF2FF"),
              new DefaultColumnDTO("Decision", 4, "#B45309", "#FBBF24", "#FFFBEB"),
              new DefaultColumnDTO("Won", 5, "#047857", "#6EE7B7", "#ECFDF5"),
              new DefaultColumnDTO("Lost", 6, "#7F1D1D", "#FCA5A5", "#FEF2F2")
        );
}
