package com.utt.dto;

import org.springframework.data.annotation.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "login", type = "logins", shards = 1)

public class logindto {

    @Id
    @Field(type = FieldType.Text)
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String phone;


//    public MultipartFile getProfilePicture() {
//        return profilePicture;
//    }
//
//    public void setProfilePicture(MultipartFile profilePicture) {
//        this.profilePicture = profilePicture;
//    }
//
//    @Column
//    @CassandraType(type= DataType.Name.BLOB)
//    @JsonIgnoreProperties
//    MultipartFile profilePicture;
//

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
