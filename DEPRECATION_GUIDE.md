# Deprecation and Migration Guide

This document describes deprecated features, their replacements, and migration paths.

## Overview

The IIIF Manifest Builder has undergone significant refactoring to improve maintainability
and reduce code duplication. Many collection-specific classes have been deprecated in favor
of unified, configurable implementations.

## Deprecation Timeline

- **Version 1.x**: Deprecated methods marked with `@Deprecated` annotation
- **Version 2.0** (Planned): Deprecated classes and methods will be removed

## Deprecated Classes and Replacements

### Canvas Creation Classes

#### 1. `Canvas.java` (DTAB-specific)

**Status**: Deprecated
**Replacement**: `CanvasCreator`

**Migration**:
```java
// OLD (Deprecated)
Canvas.createCanvas(file, jsonObj, manifest);

// NEW (Recommended)
CanvasCreator creator = new CanvasCreator(CollectionConfig.DTAB);
creator.createCanvas(file, jsonObj, manifest);

// Or use factory method
CanvasCreator.forDtab().createCanvas(file, jsonObj, manifest);
```

#### 2. `CanvasKahlen.java` (Kahlen-specific)

**Status**: Deprecated
**Replacement**: `KahlenCanvasCreator` (extends `CanvasCreator`)

**Migration**:
```java
// OLD (Deprecated)
CanvasKahlen.createCanvas(file, jsonObj, manifest);

// NEW (Recommended)
CanvasCreator creator = CanvasCreator.forKahlen();
creator.createCanvas(file, jsonObj, manifest);

// Or direct instantiation
KahlenCanvasCreator creator = new KahlenCanvasCreator();
creator.createCanvas(file, jsonObj, manifest);
```

### Configuration Classes

#### 3. `Data.java`, `Label.java`, `Summary.java`, `Url.java`

**Status**: Deprecated
**Replacement**: `CollectionConfig` enum

All collection-specific configuration has been consolidated into a single `CollectionConfig` enum.

**Migration**:
```java
// OLD (Deprecated)
String dataUrl = Data.DTAB.getDataUrl();
String label = Label.DTAB.getLabel();

// NEW (Recommended)
String dataUrl = CollectionConfig.DTAB.getDataUrl();
String label = CollectionConfig.DTAB.getLabel();
```

### ID Transformation

#### 4. `IdTransformation.idTransformator(File file)`

**Status**: Deprecated
**Replacement**: `IdTransformation.idTransformator(File file, CollectionConfig config)`

The old method applied DTAB transformation to all collections, which was incorrect.

**Migration**:
```java
// OLD (Deprecated - applies DTAB rules to all)
String id = IdTransformation.idTransformator(file);

// NEW (Recommended - collection-aware)
String id = IdTransformation.idTransformator(file, CollectionConfig.DTAB);
String id = IdTransformation.idTransformator(file, CollectionConfig.TAP);
```

## Deprecated Methods in Active Classes

### MetadataBuilder

#### Static Field Accessors

Several static field classes have been replaced by `MetadataBuilder` methods:

```java
// OLD (Verbose)
Metadata metadata = new Metadata(
    new Label("dcterms:title"),
    new Value(new I18n("en", "Title"))
);

// NEW (Builder pattern)
Metadata metadata = MetadataBuilder.create("dcterms:title", "Title")
    .withLabelLang("en")
    .build();
```

## Collection-Specific Metadata Classes

The following metadata field classes in `org.crossasia.manifest.metadata.fields` are deprecated:

- `Coll.java` → Use `CollectionConfig.getCollectionName()`
- `SummaryData.java` → Use `CollectionConfig.getSummary()`
- `RequiredStatement.java` → Use `CollectionConfig.getRequiredStatement()`
- `PartOf.java` → Use `CollectionConfig.getPartOf()`

**Migration Example**:
```java
// OLD
import org.crossasia.manifest.metadata.fields.Coll;
String collectionName = Coll.DTAB.name();

// NEW
import org.crossasia.manifest.statics.collection.CollectionConfig;
String collectionName = CollectionConfig.DTAB.getCollectionName();
```

## Removed Features

### Features Removed in Version 1.0

None yet. All deprecated features are still functional with warnings.

### Features Planned for Removal in Version 2.0

1. All collection-specific Canvas classes (`Canvas.java`, `CanvasKahlen.java`)
2. Separate configuration enums (`Data`, `Label`, `Summary`, `Url`)
3. Non-collection-aware ID transformation
4. Old metadata field helper classes

## Migration Checklist

When updating your code to use the new APIs:

- [ ] Replace all direct calls to `Canvas.createCanvas()` with `CanvasCreator`
- [ ] Replace `CanvasKahlen.createCanvas()` with `CanvasCreator.forKahlen()`
- [ ] Update all `Data`, `Label`, `Summary`, `Url` references to `CollectionConfig`
- [ ] Add `CollectionConfig` parameter to `IdTransformation` calls
- [ ] Update metadata field references to use `CollectionConfig` methods
- [ ] Test with your collection-specific data
- [ ] Review deprecation warnings during compilation

## Compilation Warnings

After migration, ensure your build has no deprecation warnings:

```bash
mvn clean compile -Xlint:deprecation
```

## Need Help?

If you encounter issues during migration:

1. Check the JavaDoc on deprecated methods for replacement suggestions
2. Review the `CollectionConfig` enum for your collection's configuration
3. Examine the test files for usage examples
4. Consult `CONFIGURATION.md` for configuration options
5. File an issue on GitHub with:
   - The deprecated code you're trying to replace
   - Your collection type
   - Error messages or unexpected behavior

## Version History

| Version | Date | Changes |
|---------|------|---------|
| 1.0 | 2024-12 | Initial deprecation of collection-specific classes |
| 2.0 | TBD | Planned removal of deprecated features |

## See Also

- [CONFIGURATION.md](CONFIGURATION.md) - Configuration guide
- [README.md](README.md) - General documentation
- JavaDoc in source code for detailed API documentation
