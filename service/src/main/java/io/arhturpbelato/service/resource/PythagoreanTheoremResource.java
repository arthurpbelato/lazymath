package io.arhturpbelato.service.resource;

import io.arhturpbelato.service.model.PythagoreanTheorem;
import io.arhturpbelato.service.service.PythagoreanTheoremService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pythagorean-theorem")
public class PythagoreanTheoremResource {

    PythagoreanTheoremService service;

    @PostMapping
    public ResponseEntity<PythagoreanTheorem> solve(@RequestBody PythagoreanTheorem theorem) {
        service.solve(theorem);
        return ResponseEntity.ok(theorem);
    }
}
