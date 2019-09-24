import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.SpringContext;
import org.improving.tag.commands.SetNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
//import static javax.print.attribute.TextSyntax.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class SetNameTest {
    SetNameCommand target;
    TestInputOutput io;
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringContext.class);

    Game game = context.getBean(Game.class);

    @BeforeEach
    public void arrange() {
        // Arrange
        io = new TestInputOutput();
        target = new SetNameCommand();
        game = mock(Game.class);


    }
    @Test
    public void execute_should_display_player_name() {
        //Act
        target.execute("@set name=Anil", game);//goodInput

        //Assert
        assertEquals("Anil", game.getPlayer().getName());
    }
    @Test
    public void execute_should_mock() {
        Player player = new Player(null);
        player.setName("hi");
        player.setHitPoints(50);
        player = spy(player);
        when(game.getPlayer()).thenReturn(player);

        //Act
        target.execute("@set name=Anil", game);//goodInput

        //Assert
        verify(player).setName("Anil");
    }
    @Test
    public void execute_should_display_player_name_with_spaces(){
        //Act
        target.execute( "            @set name=Anil           ", game);
        //Assert
        assertEquals("Anil", game.getPlayer().getName());
    }
    @Test
    public void isValid_should_be_true_when_input_is_move(){
        //Act
        var result = target.isValid("@set name=Anil", game);

        //Assert
        assertTrue(result);
    }
    @Test
    public void isValid_should_be_true_when_input_is_move_with_spaces(){
        //Act
        var result = target.isValid("    @set name=Anil      ", game);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_move_in_capital_letters(){
        //Act
        var result = target.isValid("@SET NAME=ANIL", game);

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {
        //Act
        var result = target.isValid("foobar", game);

        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {
        //Act
        var result = target.isValid(null, game);

        //Assert
        assertFalse(result);
    }
    @Test
    public void isValid_should_be_false_when_input_is_only_one_word() {
        //Act
        var result = target.isValid("@set", game);

        //Assert
        assertFalse(result);
    }


}
