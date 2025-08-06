package jp.ac.it_college.std.s24016.kotlin.exposed.dao.crud
//select：条件付き(ID)でデータを取得する(crudのr)
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberEntity
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main(){
    createSessionFactory()

    transaction {
        val member = MemberEntity.findById(2)
            ?.let(::MemberModel)
        println(member)
    }
}