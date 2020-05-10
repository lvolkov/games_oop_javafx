package ru.job4j;


import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
public class BishopBlackTest {

    @Test
    public void whenPositionTrue() {
        BishopBlack bb = new BishopBlack(Cell.D6);
        assertThat(bb.position().toString(),is("D6"));
    }


    @Test
    public void whenCopyTrue() {
        BishopBlack bb = new BishopBlack(Cell.C5);
        Figure result = bb.copy(Cell.C5);
        assertThat(bb.equals(result),is(true));
    }

    @Test
    public void whenWayFalse() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        try {
            assertThat(bb.way(Cell.C1,Cell.F5), is(true));
        } catch (IllegalStateException ex) {
            ex.getMessage();
        }

    }


}
