package hello.springmvc.basic.requestmapping.request

import com.fasterxml.jackson.databind.ObjectMapper
import hello.springmvc.basic.HelloData
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.stereotype.Controller
import org.springframework.util.StreamUtils
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.nio.charset.StandardCharsets
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class RequestBodyJsonController {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @PostMapping("/request-body-json-v1")
    fun requestBodyJsonV1(request: HttpServletRequest, response: HttpServletResponse) {

        val inputStream = request.inputStream
        val messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)

        log.info("messageBody={}", messageBody)

        val helloData = objectMapper.readValue<HelloData>(messageBody, HelloData::class.java)

        log.info("username={}, age={}", helloData.username, helloData.age)

        response.writer.write("ok")
    }

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    fun requestBodyJsonV2(@RequestBody messageBody: String): String {

        log.info("messageBody={}", messageBody)

        val helloData = objectMapper.readValue<HelloData>(messageBody, HelloData::class.java)

        log.info("username={}, age={}", helloData.username, helloData.age)

        return "ok"
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    fun requestBodyJsonV3(@RequestBody helloData: HelloData): String {

        log.info("helloData={}", helloData)
        log.info("username={}, age={}", helloData.username, helloData.age)

        return "ok"
    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    fun requestBodyJsonV4(httpEntity: HttpEntity<HelloData>): String {

        val helloData = httpEntity.body!!
        log.info("helloData={}", helloData)
        log.info("username={}, age={}", helloData.username, helloData.age)

        return "ok"
    }

    @ResponseBody
    @PostMapping("/request-body-json-v5")
    fun requestBodyJsonV5(@RequestBody helloData: HelloData): HelloData {

        log.info("helloData={}", helloData)
        log.info("username={}, age={}", helloData.username, helloData.age)

        return helloData
    }
}