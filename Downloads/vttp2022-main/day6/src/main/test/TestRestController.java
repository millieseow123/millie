import org.springframework.http.MediaType;

import jakarta.json.Json;

@SpringBootTest
public class TestRestController {
    
    @Test 
        public void shouldReturn10Quotes(){

            int count = 10; //query param

            //construct request
            RequestBuilder req = MockMvcRequestBuilders.get("/quote")
                .queryParam("count", " " + count) //append anything to string = string
                .header("X-ID", "a header")
                .accept(MediaType.APPLICATION_JSON);

            //make request
            MvcResult result = null;
                try {
                    result = mvc.perform(req).andReturn();
                } catch (Exception ex) {
                    //TODO: handle exception
                    fail("cannot perform mvc invocation", ex);
                    return;
                }
            MockHttpServletResponse resp = result.getResponse();
            try {
                //JSON
                payload = resp.getContentAsString();
            } catch (Exception ex) {
                //TODO: handle exception
                fail("cannot retrieve response payload", ex);
                return;
            }    
        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonArray quotes = reader.readArray();

        assertEquals(count, quotes.size(), "expect %s quotes. Got %s".
            formatted(count, quotes.size()));
        }

}
