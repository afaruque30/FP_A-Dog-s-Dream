import javax.json.*;

public class FileSystem {
    // provide methods to writing and reading files
    // provide methods to create directories

    // save virtual file system in JSON format

    /*
     * JSON format:
     * {
     * "OS(C:)":{
     * "type":"drive",
     * "name":"C:",
     * "path":"C:",
     * "size":"100GB",
     * "free":"100GB",
     * "content":{
     * "/":{
     * "type":"directory",
     * "children":[
     * {
     * "name":"file1.txt",
     * "type":"file",
     * "content":"Hello World!"
     * },
     * {
     * "name":"file2.txt",
     * "type":"file",
     * "content":"Hello World!"
     * }
     * ]
     * }
     * }
     * }
     * }
     * 
     */

    JsonObject fileSystem;

    public FileSystem() {
        FileSystem vfs = new FileSystem("../vfs.json");

        if (vfs.exists()) {
            JSONReader reader = new JSONReader(vfs);
            fileSystem = reader.readObject();
            System.out.println(fileSystem);
        } else {
            initVFS();
        }
    }

    public void initVFS() {
        FileSystem vfs = new FileSystem("../vfs.json");

        JsonObject vfsJson = Json.createObjectBuilder()
                .add("vfs", Json.createObjectBuilder()
                        .add("type", "drive")
                        .add("name", "C:")
                        .add("path", "C:")
                        .add("size", "100GB")
                        .add("free", "100GB")
                        .add("content", Json.createObjectBuilder()
                                .add("/", Json.createObjectBuilder()
                                        .add("type", "directory")
                                        .add("children", Json.createArrayBuilder()
                                                .add(Json.createObjectBuilder()
                                                        .add("name", "file1.txt")
                                                        .add("type", "file")
                                                        .add("content", "Hello World!"))
                                                .add(Json.createObjectBuilder()
                                                        .add("name", "file2.txt")
                                                        .add("type", "file")
                                                        .add("content", "Hello World!"))))))
                .add("Program Files", Json.createObjectBuilder()
                        .add("type", "drive")
                        .add("name", "Program Files")
                        .add("path", "Program Files")
                        .add("content", Json.createObjectBuilder().add("/", Json.createObjectBuilder()
                                .add("type", "directory")
                                .add("children", Json.createArrayBuilder()
                                        .add(Json.createObjectBuilder()
                                                .add("name", "Calculator.exe")
                                                .add("type", "file")
                                                .add("content", "Hello World!"))
                                        .add(Json.createObjectBuilder()
                                                .add("name", "TicTacToe.exe")
                                                .add("type", "file")
                                                .add("content", "Hello World!"))))))
                .build();

        JSONWriter writer = new JSONWriter(vfs);
        writer.write(vfsJson);
    }
}
