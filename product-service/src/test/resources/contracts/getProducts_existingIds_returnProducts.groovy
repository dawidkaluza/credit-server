package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Returns products with given credit ids")

    request {
        method GET()
        url '/product?creditIds=1&creditIds=2'
    }

    response {
        status 200
        body("""
        [
            {
                "creditId": 1,
                "name": "TV",
                "value": 100
            },
            {
                "creditId": 2,
                "name": "Car",
                "value": 1000
            }
        ]
        """)
        headers {
            contentType(applicationJson())
        }
    }
}