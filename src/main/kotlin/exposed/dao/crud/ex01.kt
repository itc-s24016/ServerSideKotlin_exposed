package jp.ac.it_college.std.s24016.kotlin.exposed.dao.crud
//select：全データを取得する(crudのr)
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberEntity
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main(){
    createSessionFactory()

    transaction {
        val list = MemberEntity.all().map(::MemberModel)
        list.forEach(::println)
    }
}