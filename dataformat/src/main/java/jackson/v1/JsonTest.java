package jackson.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.UserAddress;
import common.UserUtil;
import jackson.v1.factory.JacksonDataFormatFactory;

public class JsonTest {
    public static void main(String[] args) {
        ObjectMapper mapper = JacksonDataFormatFactory.objectMapper("json");
        try {
            UserAddress userAddress = UserUtil.getUserAddressInstance();

            System.out.println("Write JSON ... ... ... ");
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userAddress));

            System.out.println("Read JSON ... ... ... ");
            String userYaml = "{\n" +
                    "  \"firstName\" : \"Amit\",\n" +
                    "  \"lastName\" : \"Kaneria\",\n" +
                    "  \"address\" : [ \"130 Laidlaw Ave\", \"Jersey City\", \"NJ 07307\" ]\n" +
                    "}";

            UserAddress newUserAddress = mapper.readValue(userYaml, UserAddress.class);
            System.out.println(newUserAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
