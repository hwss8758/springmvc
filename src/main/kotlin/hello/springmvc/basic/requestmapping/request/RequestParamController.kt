package hello.springmvc.basic.requestmapping.request

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class RequestParamController {

    private val log = LoggerFactory.getLogger(this::class.java)

    @RequestMapping("/request-param-v1")
    fun requestParamV1(request: HttpServletRequest, response: HttpServletResponse) {
        val username = request.getParameter("username")
        val age = request.getParameter("age").toInt()
        log.info("username = {}, age = {}", username, age)

        response.writer.write("ok")
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    fun requestParamV2(
        @RequestParam("username") memberName: String,
        @RequestParam("age") memberAge: Int
    ): String {
        log.info("memberName = {}, memberAge = {}", memberName, memberAge)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    fun requestParamV3(
        @RequestParam username: String,
        @RequestParam age: Int
    ): String {
        log.info("memberName = {}, memberAge = {}", username, age)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    fun requestParamV4(username: String, age: Int): String {
        log.info("memberName = {}, memberAge = {}", username, age)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-v5")
    fun requestParamV5(
        @RequestParam(required = true) username: String,
        @RequestParam(required = false) age: Int
    ): String {
        log.info("memberName = {}, memberAge = {}", username, age)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    fun requestParamDefault(
        @RequestParam(defaultValue = "guest") username: String,
        @RequestParam(defaultValue = "-1") age: Int
    ): String {
        log.info("memberName = {}, memberAge = {}", username, age)
        return "ok"
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    fun requestParamMap(
        @RequestParam paramMap: Map<String, Any>
    ): String {
        log.info("memberName = {}, memberAge = {}", paramMap["username"], paramMap["age"])
        return "ok"
    }
}