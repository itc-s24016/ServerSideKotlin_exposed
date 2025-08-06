package jp.ac.it_college.std.s24016.kotlin.exposed.dao.crud
//テーブルを操作するためにクラスにする
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberEntity
import org.jetbrains.exposed.v1.jdbc.Database

fun createSessionFactory() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/exposed_example",
        driver = "org.postgresql.Driver",
        user = "exposed",
        password = "kotlin"
    )
}

data class MemberModel(
    val id: Int,
    val name: String
){
    constructor(entity: MemberEntity)
    : this(id = entity.id.value, name = entity.name)
}