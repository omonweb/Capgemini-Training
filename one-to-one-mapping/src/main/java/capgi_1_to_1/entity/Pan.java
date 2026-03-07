package capgi_1_to_1.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Pan {
    @Id
    private int pannumber;
    private String panaddress;

    @OneToOne

}
