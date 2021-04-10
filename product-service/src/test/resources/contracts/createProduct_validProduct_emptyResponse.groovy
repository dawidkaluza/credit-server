package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Creates new product")

    request {
        method POST()
        url '/product'
        headers {
            contentType(applicationJson())
        }
        body(
            creditId: $(regex("[1-9]+\\d*")),
            name: $(regex("[A-Za-z0-9 ]{3,64}")),
            value: $(regex("[1-9]+\\d*"))
        )
    }

    response {
        status 204
    }
}