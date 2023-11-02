package org.example.CreationalPatterns.Builder.after;

import org.example.CreationalPatterns.Builder.object.Exodia;
import org.example.CreationalPatterns.Builder.object.ExodiaTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.LeftArmOfTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.LeftLegOfTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.RightArmOfTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.RightLegOfTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.SummonService;

public class BuilderSummonService implements SummonService {
    @Override
    public Exodia summon() {
        Exodia exodia = Exodia.builder()
                .head(new ExodiaTheForbiddenOne())
                .leftArm(new LeftArmOfTheForbiddenOne())
                .leftLeg(new LeftLegOfTheForbiddenOne())
                .rightArm(new RightArmOfTheForbiddenOne())
                .rightLeg(new RightLegOfTheForbiddenOne())
                .build();
        System.out.println("獲得勝利");
        return exodia;
    }
}
