package kg.study.ksptestapp.network.converters


import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import kg.study.ksptestapp.data.model.Difficulty
import kg.study.ksptestapp.data.model.Gender

class GenderConverter : TypeAdapter<Gender>() {
    override fun write(out: JsonWriter, value: Gender?) {
        out.value(value?.value) // Convert enum to its string value
    }

    override fun read(`in`: JsonReader): Gender? {
        val value = `in`.nextString()
        return Gender.fromValue(value) // Convert string back to enum
    }
}

class DifficultyConverter : TypeAdapter<Difficulty>() {
    override fun write(out: JsonWriter, value: Difficulty?) {
        out.value(value?.value) // Convert enum to its string value
    }

    override fun read(`in`: JsonReader): Difficulty? {
        val value = `in`.nextString()
        return Difficulty.fromValue(value) // Convert string back to enum
    }
}