package in.gov.eci.bloapp.model.app_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import in.gov.eci.bloapp.utils.Constants;
import java.util.List;
import org.apache.xmlbeans.XmlErrorCodes;

/* JADX INFO: loaded from: /tmp/dex_9.68/classes4.dex */
public class HonbleCommissionModel {

    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("perPage")
    @Expose
    private Integer perPage;

    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    @SerializedName("totalPages")
    @Expose
    private Integer totalPages;

    @SerializedName("totalResults")
    @Expose
    private Integer totalResults;

    public class Result {

        @SerializedName("author")
        @Expose
        private Author author;

        @SerializedName("category")
        @Expose
        private Category category;

        @SerializedName("comments")
        @Expose
        private Integer comments;

        @SerializedName(XmlErrorCodes.DATE)
        @Expose
        private String date;

        @SerializedName("description")
        @Expose
        private String description;

        @SerializedName("featured")
        @Expose
        private Boolean featured;

        @SerializedName("fields")
        @Expose
        private Fields fields;

        @SerializedName("hidden")
        @Expose
        private Boolean hidden;

        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("image")
        @Expose
        private String image;

        @SerializedName("locked")
        @Expose
        private Boolean locked;

        @SerializedName("pinned")
        @Expose
        private Boolean pinned;

        @SerializedName("prefix")
        @Expose
        private Object prefix;

        @SerializedName("rating")
        @Expose
        private Integer rating;

        @SerializedName("reviews")
        @Expose
        private Integer reviews;

        @SerializedName(Constants.TITLE)
        @Expose
        private String title;

        @SerializedName("url")
        @Expose
        private String url;

        @SerializedName("views")
        @Expose
        private Integer views;

        @SerializedName("tags")
        @Expose
        private List<Object> tags = null;

        @SerializedName("topic")
        @Expose
        private List<Object> topic = null;

        public Result() {
        }

        public class Category {

            @SerializedName("class")
            @Expose
            private String class1;

            @SerializedName("id")
            @Expose
            private Integer id;

            @SerializedName("name")
            @Expose
            private String name;

            @SerializedName("parentId")
            @Expose
            private Integer parentId;

            @SerializedName("permissions")
            @Expose
            private Permissions permissions;

            @SerializedName("url")
            @Expose
            private String url;

            public Category() {
            }

            public class Permissions {

                @SerializedName("perm_2")
                @Expose
                private String perm2;

                @SerializedName("perm_3")
                @Expose
                private String perm3;

                @SerializedName("perm_4")
                @Expose
                private String perm4;

                @SerializedName("perm_5")
                @Expose
                private String perm5;

                @SerializedName("perm_6")
                @Expose
                private Object perm6;

                @SerializedName("perm_7")
                @Expose
                private Object perm7;

                @SerializedName("perm_id")
                @Expose
                private Integer permId;

                @SerializedName("perm_view")
                @Expose
                private String permView;

                public Permissions() {
                }

                public Integer getPermId() {
                    return this.permId;
                }

                public void setPermId(Integer permId) {
                    this.permId = permId;
                }

                public String getPermView() {
                    return this.permView;
                }

                public void setPermView(String permView) {
                    this.permView = permView;
                }

                public String getPerm2() {
                    return this.perm2;
                }

                public void setPerm2(String perm2) {
                    this.perm2 = perm2;
                }

                public String getPerm3() {
                    return this.perm3;
                }

                public void setPerm3(String perm3) {
                    this.perm3 = perm3;
                }

                public String getPerm4() {
                    return this.perm4;
                }

                public void setPerm4(String perm4) {
                    this.perm4 = perm4;
                }

                public String getPerm5() {
                    return this.perm5;
                }

                public void setPerm5(String perm5) {
                    this.perm5 = perm5;
                }

                public Object getPerm6() {
                    return this.perm6;
                }

                public void setPerm6(Object perm6) {
                    this.perm6 = perm6;
                }

                public Object getPerm7() {
                    return this.perm7;
                }

                public void setPerm7(Object perm7) {
                    this.perm7 = perm7;
                }
            }

            public Integer getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public String getUrl() {
                return this.url;
            }

            public String getClass1() {
                return this.class1;
            }

            public Integer getParentId() {
                return this.parentId;
            }

            public Permissions getPermissions() {
                return this.permissions;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setClass1(String class1) {
                this.class1 = class1;
            }

            public void setParentId(Integer parentId) {
                this.parentId = parentId;
            }

            public void setPermissions(Permissions permissions) {
                this.permissions = permissions;
            }
        }

        public class Fields {

            @SerializedName("field_47")
            @Expose
            private String field_47;

            @SerializedName("field_5")
            @Expose
            private String field_5;

            @SerializedName("field_6")
            @Expose
            private String field_6;

            public Fields() {
            }

            public String getField_5() {
                return this.field_5;
            }

            public String getField_6() {
                return this.field_6;
            }

            public String getField_47() {
                return this.field_47;
            }

            public void setField_5(String field_5) {
                this.field_5 = field_5;
            }

            public void setField_6(String field_6) {
                this.field_6 = field_6;
            }

            public void setField_47(String field_47) {
                this.field_47 = field_47;
            }
        }

        public class Author {

            @SerializedName("achievements_points")
            @Expose
            private Integer achievementsPoints;

            @SerializedName("allowAdminEmails")
            @Expose
            private Boolean allowAdminEmails;

            @SerializedName("birthday")
            @Expose
            private String birthday;

            @SerializedName("coverPhotoUrl")
            @Expose
            private String coverPhotoUrl;

            @SerializedName("customFields")
            @Expose
            private CustomFields customFields;

            @SerializedName("email")
            @Expose
            private String email;

            @SerializedName("formattedName")
            @Expose
            private String formattedName;

            @SerializedName("id")
            @Expose
            private Integer id;

            @SerializedName("joined")
            @Expose
            private String joined;

            @SerializedName("lastActivity")
            @Expose
            private Object lastActivity;

            @SerializedName("lastPost")
            @Expose
            private String lastPost;

            @SerializedName("lastVisit")
            @Expose
            private String lastVisit;

            @SerializedName("name")
            @Expose
            private String name;

            @SerializedName("photoUrl")
            @Expose
            private String photoUrl;

            @SerializedName("photoUrlIsDefault")
            @Expose
            private Boolean photoUrlIsDefault;

            @SerializedName("posts")
            @Expose
            private Integer posts;

            @SerializedName("primaryGroup")
            @Expose
            private PrimaryGroup primaryGroup;

            @SerializedName("profileUrl")
            @Expose
            private String profileUrl;

            @SerializedName("profileViews")
            @Expose
            private Integer profileViews;

            @SerializedName("rank")
            @Expose
            private Rank rank;

            @SerializedName("registrationIpAddress")
            @Expose
            private String registrationIpAddress;

            @SerializedName("reputationPoints")
            @Expose
            private Integer reputationPoints;

            @SerializedName("secondaryGroups")
            @Expose
            private List<Object> secondaryGroups = null;

            @SerializedName("timeZone")
            @Expose
            private String timeZone;

            @SerializedName(Constants.TITLE)
            @Expose
            private Object title;

            @SerializedName("validating")
            @Expose
            private Boolean validating;

            @SerializedName("warningPoints")
            @Expose
            private Integer warningPoints;

            public Author() {
            }

            public Integer getId() {
                return this.id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getTitle() {
                return this.title;
            }

            public void setTitle(Object title) {
                this.title = title;
            }

            public String getTimeZone() {
                return this.timeZone;
            }

            public void setTimeZone(String timeZone) {
                this.timeZone = timeZone;
            }

            public String getFormattedName() {
                return this.formattedName;
            }

            public void setFormattedName(String formattedName) {
                this.formattedName = formattedName;
            }

            public PrimaryGroup getPrimaryGroup() {
                return this.primaryGroup;
            }

            public void setPrimaryGroup(PrimaryGroup primaryGroup) {
                this.primaryGroup = primaryGroup;
            }

            public List<Object> getSecondaryGroups() {
                return this.secondaryGroups;
            }

            public void setSecondaryGroups(List<Object> secondaryGroups) {
                this.secondaryGroups = secondaryGroups;
            }

            public String getEmail() {
                return this.email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getJoined() {
                return this.joined;
            }

            public void setJoined(String joined) {
                this.joined = joined;
            }

            public String getRegistrationIpAddress() {
                return this.registrationIpAddress;
            }

            public void setRegistrationIpAddress(String registrationIpAddress) {
                this.registrationIpAddress = registrationIpAddress;
            }

            public Integer getWarningPoints() {
                return this.warningPoints;
            }

            public void setWarningPoints(Integer warningPoints) {
                this.warningPoints = warningPoints;
            }

            public Integer getReputationPoints() {
                return this.reputationPoints;
            }

            public void setReputationPoints(Integer reputationPoints) {
                this.reputationPoints = reputationPoints;
            }

            public String getPhotoUrl() {
                return this.photoUrl;
            }

            public void setPhotoUrl(String photoUrl) {
                this.photoUrl = photoUrl;
            }

            public Boolean getPhotoUrlIsDefault() {
                return this.photoUrlIsDefault;
            }

            public void setPhotoUrlIsDefault(Boolean photoUrlIsDefault) {
                this.photoUrlIsDefault = photoUrlIsDefault;
            }

            public String getCoverPhotoUrl() {
                return this.coverPhotoUrl;
            }

            public void setCoverPhotoUrl(String coverPhotoUrl) {
                this.coverPhotoUrl = coverPhotoUrl;
            }

            public String getProfileUrl() {
                return this.profileUrl;
            }

            public void setProfileUrl(String profileUrl) {
                this.profileUrl = profileUrl;
            }

            public Boolean getValidating() {
                return this.validating;
            }

            public void setValidating(Boolean validating) {
                this.validating = validating;
            }

            public Integer getPosts() {
                return this.posts;
            }

            public void setPosts(Integer posts) {
                this.posts = posts;
            }

            public Object getLastActivity() {
                return this.lastActivity;
            }

            public void setLastActivity(Object lastActivity) {
                this.lastActivity = lastActivity;
            }

            public String getLastVisit() {
                return this.lastVisit;
            }

            public void setLastVisit(String lastVisit) {
                this.lastVisit = lastVisit;
            }

            public String getLastPost() {
                return this.lastPost;
            }

            public void setLastPost(String lastPost) {
                this.lastPost = lastPost;
            }

            public String getBirthday() {
                return this.birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public Integer getProfileViews() {
                return this.profileViews;
            }

            public void setProfileViews(Integer profileViews) {
                this.profileViews = profileViews;
            }

            public CustomFields getCustomFields() {
                return this.customFields;
            }

            public void setCustomFields(CustomFields customFields) {
                this.customFields = customFields;
            }

            public Rank getRank() {
                return this.rank;
            }

            public void setRank(Rank rank) {
                this.rank = rank;
            }

            public Integer getAchievementsPoints() {
                return this.achievementsPoints;
            }

            public void setAchievementsPoints(Integer achievementsPoints) {
                this.achievementsPoints = achievementsPoints;
            }

            public Boolean getAllowAdminEmails() {
                return this.allowAdminEmails;
            }

            public void setAllowAdminEmails(Boolean allowAdminEmails) {
                this.allowAdminEmails = allowAdminEmails;
            }

            public class PrimaryGroup {

                @SerializedName("formattedName")
                @Expose
                private String formattedName;

                @SerializedName("id")
                @Expose
                private Integer id;

                @SerializedName("name")
                @Expose
                private String name;

                public PrimaryGroup() {
                }

                public Integer getId() {
                    return this.id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public String getName() {
                    return this.name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getFormattedName() {
                    return this.formattedName;
                }

                public void setFormattedName(String formattedName) {
                    this.formattedName = formattedName;
                }
            }

            public class CustomFields {
                public CustomFields() {
                }
            }

            public class Rank {

                @SerializedName("id")
                @Expose
                private Integer id;

                @SerializedName("name")
                @Expose
                private String name;

                @SerializedName("points")
                @Expose
                private Integer points;

                public Rank() {
                }

                public Integer getId() {
                    return this.id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public String getName() {
                    return this.name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Integer getPoints() {
                    return this.points;
                }

                public void setPoints(Integer points) {
                    this.points = points;
                }
            }
        }

        public Integer getId() {
            return this.id;
        }

        public String getTitle() {
            return this.title;
        }

        public Category getCategory() {
            return this.category;
        }

        public Fields getFields() {
            return this.fields;
        }

        public Author getAuthor() {
            return this.author;
        }

        public String getDate() {
            return this.date;
        }

        public String getDescription() {
            return this.description;
        }

        public Integer getComments() {
            return this.comments;
        }

        public Integer getReviews() {
            return this.reviews;
        }

        public Integer getViews() {
            return this.views;
        }

        public Object getPrefix() {
            return this.prefix;
        }

        public List<Object> getTags() {
            return this.tags;
        }

        public Boolean getLocked() {
            return this.locked;
        }

        public Boolean getHidden() {
            return this.hidden;
        }

        public Boolean getPinned() {
            return this.pinned;
        }

        public Boolean getFeatured() {
            return this.featured;
        }

        public String getUrl() {
            return this.url;
        }

        public Integer getRating() {
            return this.rating;
        }

        public String getImage() {
            return this.image;
        }

        public List<Object> getTopic() {
            return this.topic;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public void setFields(Fields fields) {
            this.fields = fields;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setComments(Integer comments) {
            this.comments = comments;
        }

        public void setReviews(Integer reviews) {
            this.reviews = reviews;
        }

        public void setViews(Integer views) {
            this.views = views;
        }

        public void setPrefix(Object prefix) {
            this.prefix = prefix;
        }

        public void setTags(List<Object> tags) {
            this.tags = tags;
        }

        public void setLocked(Boolean locked) {
            this.locked = locked;
        }

        public void setHidden(Boolean hidden) {
            this.hidden = hidden;
        }

        public void setPinned(Boolean pinned) {
            this.pinned = pinned;
        }

        public void setFeatured(Boolean featured) {
            this.featured = featured;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setTopic(List<Object> topic) {
            this.topic = topic;
        }
    }

    public Integer getPage() {
        return this.page;
    }

    public Integer getPerPage() {
        return this.perPage;
    }

    public Integer getTotalResults() {
        return this.totalResults;
    }

    public Integer getTotalPages() {
        return this.totalPages;
    }

    public List<Result> getResults() {
        return this.results;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
