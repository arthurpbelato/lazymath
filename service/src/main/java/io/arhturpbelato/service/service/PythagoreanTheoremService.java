package io.arhturpbelato.service.service;

import io.arhturpbelato.service.model.PythagoreanTheorem;
import org.springframework.stereotype.Service;

@Service
public class PythagoreanTheoremService {

    public void solve(PythagoreanTheorem theorem) {
        theorem.solve();
    }

}
