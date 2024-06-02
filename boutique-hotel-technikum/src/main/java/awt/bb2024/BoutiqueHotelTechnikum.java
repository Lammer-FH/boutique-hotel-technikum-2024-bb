package awt.bb2024;

import awt.bb2024.Controller.BookingController;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoutiqueHotelTechnikum {

    public static void main(String[] args) {
        SpringApplication.run(BoutiqueHotelTechnikum.class, args);
        BookingController controller = new BookingController();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
