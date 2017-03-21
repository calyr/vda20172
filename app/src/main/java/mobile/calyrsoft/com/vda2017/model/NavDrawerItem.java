package mobile.calyrsoft.com.vda2017.model;

/**
 * <p> The NavDrawerItem class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class NavDrawerItem{
        private boolean showNotify;
        private String title;
        private int titleicon;


        public NavDrawerItem() {

        }

        public NavDrawerItem(boolean showNotify, String title,int titleicon) {
            this.showNotify = showNotify;
            this.title = title;
            this.titleicon = titleicon;
        }

        public boolean isShowNotify() {
            return showNotify;
        }

        public void setShowNotify(boolean showNotify) {
            this.showNotify = showNotify;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTitleicon() {
            return titleicon;
        }

        public void setTitleicon(int titleicon) {
            this.titleicon = titleicon;
        }
}
