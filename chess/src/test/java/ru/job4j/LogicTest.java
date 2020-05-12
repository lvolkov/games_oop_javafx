package ru.job4j;

import org.junit.Test;

import ru.job4j.chess.Logic;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LogicTest {

    @Test
    public void whenCanMove() {
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.C1);
        logic.add(bb);
        boolean result = logic.move(Cell.C1, Cell.G5);
        assertThat(result, is(true));
    }

    @Test(expected = IllegalStateException.class)
    public void whenCantMoveNotDiagonal() {
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.C1);
        logic.add(bb);
        boolean result = logic.move(Cell.C1, Cell.F5);
        try {
            assertThat(result, is(false));
        } catch (IllegalStateException ex) {
            ex.getMessage();
        }
    }

    @Test
    public void whenCantMoveBecauseOfFigure() {
        Logic logic = new Logic();
        BishopBlack bb = new BishopBlack(Cell.C1);
        logic.add(bb);
        PawnBlack pb = new PawnBlack(Cell.G5);
        logic.add(pb);
        boolean result = logic.move(Cell.C1, Cell.G5);
        assertThat(result, is(false));
    }
}