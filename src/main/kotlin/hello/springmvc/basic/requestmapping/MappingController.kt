package hello.springmvc.basic.requestmapping

import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MappingController {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @RequestMapping("/hello-basic")
    fun helloBasic(): String {
        logger.info("helloBasic")
        return "ok"
    }

    @GetMapping("/mapping/{userId}")
    fun mappingPath(@PathVariable("userId") data: String): String {
        logger.info("mappingPath userId = {}", data)
        return "ok"
    }

    @GetMapping("/mapping2/{userId}")
    fun mappingPath2(@PathVariable userId: String): String {
        logger.info("mappingPath userId = {}", userId)
        return "ok"
    }

    @GetMapping(value = ["/mapping-param"], params = ["mode=debug"])
    fun mappingParam(): String {
        logger.info("mappingParam")
        return "ok"
    }

    @GetMapping(value = ["/mapping-header"], headers = ["mode=debug"])
    fun mappingHeader(): String {
        logger.info("mappingHeader")
        return "ok"
    }

    @PostMapping(value = ["/mapping-consume"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun mappingConsumes(): String {
        logger.info("mappingConsumes")
        return "ok"
    }

    @PostMapping(value = ["/mapping-produce"], produces = [MediaType.TEXT_HTML_VALUE])
    fun mappingProduce(): String {
        logger.info("mappingProduce")
        return "ok"
    }
}