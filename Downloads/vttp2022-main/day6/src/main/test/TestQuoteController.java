package vttp2022.ssf.day6.test;

import java.beans.Transient;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@AutoConfigureMockMvc
public class TestQuoteController {

    @Autowired
    private MockMvc mvc; //mockMVC grabs MVC, helps to test controller 

    @Test
    public void shouldReturn200(){
        //build request
        RequestBuilder req = MockMvcRequestBuilders.get("/quote")
            .accept(MediaTYpe.TEST_HTML_VALUE);

        //call controller
        MvcResult result = null;
        try{
        result = mvc.perform(req).andReturn();
        } catch (Exception ex){
            fail("cannot peform mvc invocation", ex);
            return;
        }
        //Get response
        MockHttpServletResponse resp = result.getResponse();
        try{
            String payload = resp.getContentAsString();
            assertNotNull(payload);
        } catch (Exception ex){
            fail("cannot retrieve response payload", ex);
            return;
        }
    }
}
