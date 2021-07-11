package com.example.crudoperation;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Piyush Kumar.
 * @since 04/07/21.
 */

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Extra {

    private String sports;
    private String curricularTitles;

}
