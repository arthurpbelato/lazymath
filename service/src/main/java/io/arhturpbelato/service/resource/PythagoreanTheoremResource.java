package io.arhturpbelato.service.resource;

import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.PythagoreanTheoremService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pythagorean-theorem")
@Api(value = "API REST Pythagorean Theorem", tags = "Pythagorean Theorem")
public class PythagoreanTheoremResource {

    private final PythagoreanTheoremService service;

    @PostMapping
    @ApiOperation(value = "Solve pythagorean theorem.")
    @SneakyThrows
    public ResponseEntity<PythagoreanTheorem> solve(@RequestBody PythagoreanTheorem theorem) {
        service.solve(theorem);
        return ResponseEntity.ok(theorem);
    }
}
