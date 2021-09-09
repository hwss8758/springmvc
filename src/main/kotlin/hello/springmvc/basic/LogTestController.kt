package hello.springmvc.basic

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class LogTestController {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @RequestMapping("/log-test")
    fun logTest(): String {
        val name = "Spring"

        // 이렇게 쓰면 안된다.
        logger.info("info log = $name")

        // 이런식으로 사용해야한다.
        logger.trace("trace log = {}", name)
        logger.debug("debug log = {}", name)
        logger.warn("warn log = {}", name)
        logger.error("error log = {}", name)
        logger.info("info log = {}", name)

        return "ok"
    }
}