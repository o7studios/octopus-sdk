package studio.o7.octopus.sdk.structs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.protobuf.Struct;
import com.google.protobuf.util.JsonFormat;
import lombok.NonNull;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ProtoStruct {
    private static final Logger LOGGER = Logger.getLogger("ProtoStruct");
    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();
    private static final JsonFormat.Parser PARSER = JsonFormat.parser();
    private static final JsonFormat.Printer PRINTER = JsonFormat.printer();

    public final Struct serialize() throws IOException {
        var builder = Struct.newBuilder();
        var json = GSON.toJson(this);
        LOGGER.log(Level.FINE, "Serialized '" + this + "' into '" + json + "'");
        PARSER.merge(json, builder);
        return builder.build();
    }

    public static <T> T deserialize(@NonNull Struct struct, @NonNull Class<T> clazz) throws IOException {
        var json = PRINTER.print(struct);
        LOGGER.log(Level.FINE, "Deserialized '" + json + "' into '" + clazz + "'");
        return GSON.fromJson(json, clazz);
    }
}
