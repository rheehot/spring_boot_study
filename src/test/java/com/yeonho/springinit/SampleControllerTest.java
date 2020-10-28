package com.yeonho.springinit;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SampleController.class)
class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebClient webClient;

    @Test
    public void sample() throws Exception {
        //  요청 "/"
        //  응답
        //  - 모델 name : jihan
        //  - 뷰 이름 : sample

        mockMvc.perform(get("/sample"))
                .andExpect(status().isOk())
                .andExpect(view().name("sample"))
                .andExpect(model().attribute("name", is("jihan")))
                .andExpect(content().string(containsString("jihan")));
    }

    @Test
    public void sampleHtmlUnit() throws Exception {
        HtmlPage page = webClient.getPage("/sample");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("jihan");
    }

    @Test
    public void hateoasTest() throws Exception {
        mockMvc.perform(get("/hateoas"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self").exists());
    }
}