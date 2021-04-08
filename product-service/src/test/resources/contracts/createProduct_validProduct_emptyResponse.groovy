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
            creditId: 3,
            name: "Computer",
            value: 500
        )
    }

    response {
        status 204
    }
}