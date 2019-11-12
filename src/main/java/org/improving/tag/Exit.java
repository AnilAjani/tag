package org.improving.tag;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
@Entity (name = "exits")
public class Exit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DestinationId")
    private Location destination;

    @Transient
    private List<String> aliases = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "originId")
    private Location origin;

    public Exit() {
    }

    public Exit(String name, Location destination, String... aliases) {
        this.id = id;
        this.name = name;
        this.destination = destination;

        this.aliases.addAll(Arrays.asList(aliases));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public void addAlias(String alias) {
        this.aliases.add(alias);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getOriginId() {
//        return originId;
//    }
//
//    public void setOriginId(int originId) {
//        this.originId = originId;
//    }



    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, destination);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit) obj;
            return this.getName().equals(exit.getName()) &&
                    this.destination.equals(exit.getDestination());
        }
        return super.equals(obj);

    }
}
