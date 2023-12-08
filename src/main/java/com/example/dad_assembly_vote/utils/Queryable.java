package com.example.dad_assembly_vote.utils;

import java.util.List;

public record Queryable<T>(
        int page,
        int total,
        int perPage,
        List<T> items
) {
}
