package io.github.winter.boot.util;

/**
 * 字符串转换
 *
 * @author changebooks@qq.com
 */
public final class StringCast {

    private StringCast() {
    }

    /**
     * 下划线 to 驼峰式
     *
     * @param s eg: "user_id"
     * @return eg: "userId"
     */
    public static String underscoreToCamel(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        boolean prevUnderscore = false;

        char[] characters = s.toCharArray();
        for (char c : characters) {
            if (c == '_') {
                prevUnderscore = true;
                continue;
            }

            if (prevUnderscore) {
                prevUnderscore = false;
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }

    /**
     * 驼峰式 to 下划线
     *
     * @param s eg: "userId"
     * @return eg: "user_id"
     */
    public static String camelToUnderscore(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        char[] characters = s.toCharArray();
        for (char c : characters) {
            if (Character.isUpperCase(c)) {
                if (result.isEmpty()) {
                    result.append(Character.toLowerCase(c));
                } else {
                    result.append('_')
                            .append(Character.toLowerCase(c));
                }
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    /**
     * 首字母大写
     *
     * @param s eg: "user"
     * @return eg: "User"
     */
    public static String upperFirst(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        } else {
            return Character.toUpperCase(s.charAt(0)) + s.substring(1);
        }
    }

}
