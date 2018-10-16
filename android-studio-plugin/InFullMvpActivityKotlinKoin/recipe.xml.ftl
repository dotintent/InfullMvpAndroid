<?xml version="1.0"?>
<recipe>

    <instantiate from="root/res/layout/activity.xml.ftl"
                 to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
    <open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />

    <instantiate from="root/src/mvp_folder/Activity.kt.ftl"
                 to="${newFolder}/${activityClass}.kt" />
    <open file="${newFolder}/${activityClass}.kt" />

    <instantiate from="root/src/mvp_folder/View.kt.ftl"
                 to="${newFolder}/${viewClass}.kt" />
    <open file="${newFolder}/${viewClass}.kt" />

    <instantiate from="root/src/mvp_folder/Model.kt.ftl"
                 to="${newFolder}/${modelClass}.kt" />
    <open file="${newFolder}/${modelClass}.kt" />

    <instantiate from="root/src/mvp_folder/Presenter.kt.ftl"
                 to="${newFolder}/${presenterClass}.kt" />
    <open file="${newFolder}/${presenterClass}.kt" />

    <instantiate from="root/src/mvp_folder/di/Module.kt.ftl"
                 to="${newFolder}/di/${moduleFileName}.kt" />

</recipe>
