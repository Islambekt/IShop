package galaxy.templates.models;


import galaxy.templates.utils.ObjectUtils;

import java.io.Serializable;

public abstract class GEntity<ID extends Serializable> extends GObject {

    public ID getId() {
        return null;
    }

    public boolean isDisabled() {
        return false;
    }

    public String getRedisKey() {
        return ObjectUtils.toStringOrNull(getId());
    }

    public String getDictId() {
        return ObjectUtils.toStringOrNull(getId());
    }

    public String getDictKey() {
        if (getDictId() == null) return null;
        return ("db." + this.getClass().getSimpleName() + "." + getDictId()).toLowerCase();
    }
}
