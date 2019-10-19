package at.htl.library.model;

public class Genre {
    private Long id;
    private String genreType;

    public Genre(Long id, String genreType) {
        this.id = id;
        this.genreType = genreType;
    }

    public Genre() {
    }

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenreType() {
        return genreType;
    }

    public void setGenreType(String genreType) {
        this.genreType = genreType;
    }
    //endregion

    @Override
    public String toString() {
        return this.genreType;
    }
}
