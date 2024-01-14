package com.ahmad.samir.univeristy.system.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "guardianName",
                column = @Column(name = "Guardian_Name")
        ),
        @AttributeOverride(
                name = "guardianMobile",
                column = @Column(name = "Guardian_Mobile")
        )
}
)
public class Guardian {

    private String guardianName;

    private String guardianMobile;
}
