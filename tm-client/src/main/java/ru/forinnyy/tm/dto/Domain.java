package ru.forinnyy.tm.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import ru.forinnyy.tm.model.Project;
import ru.forinnyy.tm.model.Task;
import ru.forinnyy.tm.model.User;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@XmlRootElement
@NoArgsConstructor
@XmlType(name = "domain")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "domain")
public final class Domain implements Serializable {

    private static final long serialVersionUID = 1;

    @NonNull
    private String id = UUID.randomUUID().toString();

    @NonNull
    private Date created = new Date();

    @NonNull
    @JsonProperty("user")
    @XmlElement(name = "user")
    @XmlElementWrapper(name = "users")
    @JacksonXmlElementWrapper(localName = "users")
    private List<User> users = new ArrayList<>();

    @NonNull
    @JsonProperty("project")
    @XmlElement(name = "project")
    @XmlElementWrapper(name = "projects")
    @JacksonXmlElementWrapper(localName = "projects")
    private List<Project> projects = new ArrayList<>();

    @NonNull
    @JsonProperty("task")
    @XmlElement(name = "task")
    @XmlElementWrapper(name = "tasks")
    @JacksonXmlElementWrapper(localName = "tasks")
    private List<Task> tasks = new ArrayList<>();

}
