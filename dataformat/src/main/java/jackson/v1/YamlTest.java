package jackson.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.UserAddress;
import common.UserUtil;
import jackson.v1.factory.JacksonDataFormatFactory;

public class YamlTest {
    public static void main(String[] args) {
        ObjectMapper mapper = JacksonDataFormatFactory.objectMapper("yaml");
        try {
            UserAddress userAddress = UserUtil.getUserAddressInstance();

            System.out.println("Write YAML ... ... ... ");
            System.out.println(mapper.writeValueAsString(userAddress));

            System.out.println("Read YAML ... ... ... ");
            String userYaml = "---\n" +
                    "firstName: \"Amit\"\n" +
                    "lastName: \"Kaneria\"\n" +
                    "address:\n" +
                    "- \"130 Laidlaw Ave\"\n" +
                    "- \"Jersey City\"\n" +
                    "- \"NJ 07307\"";

            UserAddress newUserAddress = mapper.readValue(userYaml, UserAddress.class);
            System.out.println(newUserAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
