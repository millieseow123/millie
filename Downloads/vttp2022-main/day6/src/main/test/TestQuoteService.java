package vttp2022.ssf.day6.test;

import org.springframework.beans.factory.annotation.Autowired;

public class TestQuoteService {

    @SpringBootTest
    public class TestQUoteService{

        @Autowired
        private QuoteService quoteSvc;

        @Test 
        public void shouldReturn3Quote(){
            int count =3;

            Collection<String> result = quoteSvc.getQuotes(count);
            
            assertEquals(count, result.size(), "Request the number of quotes");
        }
    }
}
