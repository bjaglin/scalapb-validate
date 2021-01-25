package scalapb.validate

import protocbridge.Artifact
import scalapb.GeneratorOption
import protocbridge.SandboxedJvmGenerator

object gen {
  def apply(
      options: GeneratorOption*
  ): (SandboxedJvmGenerator, Seq[String]) =
    (
      SandboxedJvmGenerator.forModule(
        "scala",
        Artifact(
          "com.thesamet.scalapb",
          "scalapb-validate-codegen_2.12",
          scalapb.validate.compiler.BuildInfo.version
        ),
        Seq(
          Artifact(
            "com.thesamet.scalapb",
            "compilerplugin",
            scalapb.compiler.Version.scalapbVersion
          )
        ),
        "scalapb.validate.compiler.CodeGenerator$",
        scalapb.validate.compiler.CodeGenerator.suggestedDependencies
      ),
      options.map(_.toString)
    )

  def apply(
      options: Set[GeneratorOption] = Set.empty
  ): (SandboxedJvmGenerator, Seq[String]) = apply(options.toSeq: _*)
}
