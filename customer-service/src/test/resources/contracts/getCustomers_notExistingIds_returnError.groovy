package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Returns error for not existing ids")

    request {
        method GET()
        url '/customer?creditIds=3'
    }

    response {
        status 404
        body(
            status: 404,
            timestamp: $(nonBlank()),
            message: $(nonBlank())
        )
        headers {
            contentType(applicationJson())
        }
    }
}