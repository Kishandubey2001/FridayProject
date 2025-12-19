package utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonUtils {
	
	public static <T> T readJsonToPojo(String filePath, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(filePath), clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }

}
