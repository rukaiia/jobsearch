package com.example.hm49.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RespondedApplicant {

        @NotNull(message = "Id не может быть пустым")

        private int id;

        private int resumeId;

        private int vacancyId;
        private boolean confirmation;


}
