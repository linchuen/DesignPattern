package org.example.CreationalPatterns.Builder.beofre;

import org.example.CreationalPatterns.Builder.object.Exodia;
import org.example.CreationalPatterns.Builder.object.ExodiaTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.LeftArmOfTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.LeftLegOfTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.RightArmOfTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.RightLegOfTheForbiddenOne;
import org.example.CreationalPatterns.Builder.object.SummonService;

public class SetterSummonService implements SummonService {
    @Override
    public Exodia summon() {
        Exodia exodia = new Exodia();
        exodia.setHead(new ExodiaTheForbiddenOne());
        exodia.setLeftArm(new LeftArmOfTheForbiddenOne());
        exodia.setLeftLeg(new LeftLegOfTheForbiddenOne());
        exodia.setRightArm(new RightArmOfTheForbiddenOne());
        exodia.setRightLeg(new RightLegOfTheForbiddenOne());

        checkWin(exodia);
        return exodia;
    }

    private static void checkWin(Exodia exodia) {
        assert exodia.getHead() != null;
        assert exodia.getLeftArm() != null;
        assert exodia.getLeftLeg() != null;
        assert exodia.getRightArm() != null;
        assert exodia.getRightLeg() != null;
        System.out.println("獲得勝利");
    }
}
