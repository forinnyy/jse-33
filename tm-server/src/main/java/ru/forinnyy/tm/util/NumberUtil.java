package ru.forinnyy.tm.util;

import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.text.DecimalFormat;

@NoArgsConstructor
public final class NumberUtil {

    private static final double KILOBYTE = 1024;

    private static final double MEGABYTE = KILOBYTE * 1024;

    private static final double GIGABYTE = MEGABYTE * 1024;

    private static final double TERABYTE = GIGABYTE * 1024;

    @NonNull
    private static final String NAME_BYTES = "B";

    @NonNull
    private static final String NAME_BYTES_LONG = "Bytes";

    @NonNull
    private static final String NAME_KILOBYTE = "KB";

    @NonNull
    private static final String NAME_MEGABYTE = "MB";

    @NonNull
    private static final String NAME_GIGABYTE = "GB";

    @NonNull
    private static final String NAME_TERABYTE = "TB";

    @NonNull
    private static final String SEPARATOR = " ";

    @NonNull
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###");

    @NonNull
    private static String render(final double bytes) {
        return DECIMAL_FORMAT.format(bytes);
    }

    @NonNull
    private static String render(final long bytes, final double size) {
        return render(bytes / size);
    }

    @NonNull
    private static String render(final long bytes, final double size, @NonNull final String name) {
        return render(bytes, size) + SEPARATOR + name;
    }

    @NonNull
    private static String render(final long bytes, @NonNull final String name) {
        return render(bytes) + SEPARATOR + name;
    }

    @NonNull
    public static String formatBytes(final long bytes) {
        if ((bytes >= 0) && (bytes < KILOBYTE)) return render(bytes, NAME_BYTES);
        if ((bytes >= KILOBYTE) && (bytes < MEGABYTE)) return render(bytes, KILOBYTE, NAME_KILOBYTE);
        if ((bytes >= MEGABYTE) && (bytes < GIGABYTE)) return render(bytes, MEGABYTE, NAME_MEGABYTE);
        if ((bytes >= GIGABYTE) && (bytes < TERABYTE)) return render(bytes, GIGABYTE, NAME_GIGABYTE);
        if (bytes >= TERABYTE) render(bytes, TERABYTE, NAME_TERABYTE);
        return render(bytes, NAME_BYTES_LONG);
    }

}
