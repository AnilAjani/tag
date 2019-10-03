import org.improving.tag.Exit;
import org.improving.tag.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExitTest {

    @Test
    public void toString_Should_Include_Name(){
        //Arrange
        var target = new Exit("Door", new Location());
        //Act
        var result = target.toString();
        //Assert
        assertTrue(result.contains("Door"));
    }
    @Test
    public void Equals_Should_Be_True_When_Name_And_Destination_Match(){
        //Arrange
        var destination = new Location();
        var exit1 = new Exit("Door", destination);
        var exit2 = new Exit("Door", destination, "this");
        //Act
        var result = exit1.equals(exit2);
        //Assert
        assertTrue(result);
    }
    @Test
    public void Equals_Should_Be_False_When_Compared_To_Non_Exit(){
        //Arrange
        var destination = new Location();
        var exit1 = new Exit("Door", destination);
        //Act
        var result = exit1.equals("Door");
        //Assert
        assertFalse(result);
    }
    @Test
    public void Equals_Should_Be_True_When_Name_And_Destination_Match_Of_Course(){
        //Arrange
        var destination1 = new Exit ("Door", new Location());
        var destination2 = new Exit ("Door", new Location(), "this");
        //Act
        var result = destination1.equals(destination2);
        //Assert
        assertTrue(result);
    }
}
