//import org.improving.tag.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.Dictionary;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class SaveGameFactoryTest {
//
//    private TestInputOutput io;
//    private FileSystemAdapter fsa;
//    private SaveGameFactory target;
//    private Game g;
//
//    @BeforeEach
//    public void setup(){
//        io = new TestInputOutput();
//        fsa = mock(FileSystemAdapter.class);
//        target = new SaveGameFactory(fsa, io);
//        g = new Game(null, io, target, new WorldBuilder());
//    }
//
//    @Test
//    public void save_should_preserve_location_name() throws IOException {
//        //Arrange
//        Class<Map<String, String>>dictClass = (Class<Map<String, String>>)(Class)Dictionary.class;
//        ArgumentCaptor<Map<String, String>> contentsCaptor = ArgumentCaptor.forClass(dictClass);
//        when(fsa.saveToFile((any()))).thenReturn("this is dumb");
//
//        //Act
//        String path = target.save(g);
//
//        //Assert
//        verify(fsa).saveToFile(contentsCaptor.capture());
//        var loc = contentsCaptor.getValue().get("location");
//        assertEquals("The Deathly Hallows", loc);
//        verify(fsa).saveToFile(any());
//        assertNotNull(path);
//        assertNotEquals("", path);
//
//    }
//    @Test
//    public void load_should_load_save_file() throws IOException {
//        // Arrange
//        String path = "this is a fake path";
//        when(fsa.loadFile(path)).thenReturn(Map.of("location", "The Amazon"));
//        //Act
//        target.load(path, g);
//        //Assert
//        assertEquals("The Amazon", g.getPlayer().getLocation().getName());
//    }
//}
