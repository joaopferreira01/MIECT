from vtkmodules.all import *

def main():
    # ======== Primeiro Cone ======== #
    # Criação da fonte do primeiro cone
    coneSource = vtkConeSource()
    coneSource.SetHeight(2.0)
    coneSource.SetRadius(1.0)
    coneSource.SetResolution(30)

    # Mapper para o primeiro cone
    coneMapper = vtkPolyDataMapper()
    coneMapper.SetInputConnection(coneSource.GetOutputPort())

    # Primeiro ator (actor) com propriedades específicas
    coneActor = vtkActor()
    coneActor.SetMapper(coneMapper)
    coneActor.GetProperty().SetColor(0.2, 0.63, 0.79)   # Cor azul clara
    coneActor.GetProperty().SetDiffuse(0.7)
    coneActor.GetProperty().SetSpecular(0.4)
    coneActor.GetProperty().SetSpecularPower(20)
    coneActor.GetProperty().SetOpacity(0.5)             # Opacidade de 0.5

    # ======== Segundo Cone ======== #
    # Propriedades compartilhadas para o segundo cone
    property = vtkProperty()
    property.SetColor(1.0, 0.3882, 0.2784)              # Cor laranja
    property.SetDiffuse(0.7)
    property.SetSpecular(0.4)
    property.SetSpecularPower(20)
    property.SetOpacity(0.5)                            # Opacidade de 0.5

    # Segundo ator (actor) com as mesmas propriedades e mesmo mapper
    coneActor2 = vtkActor()
    coneActor2.SetMapper(coneMapper)
    coneActor2.SetPosition(0, 0, 0)                     # Translação no eixo Y
    coneActor2.SetProperty(property)

    # ======== Renderer ======== #
    # Criação do renderer e adição dos dois atores
    ren = vtkRenderer()
    ren.AddActor(coneActor)
    ren.AddActor(coneActor2)
    ren.SetBackground(1.0, 0.55, 0.41)                  # Cor de fundo

    # ======== Render Window ======== #
    # Criação da janela de renderização
    renWin = vtkRenderWindow()
    renWin.AddRenderer(ren)
    renWin.SetSize(640, 480)
    renWin.SetWindowName('Two Cones with Properties')

    # ======== Interactor ======== #
    # Adicionando interatividade à janela de renderização
    iren = vtkRenderWindowInteractor()
    iren.SetRenderWindow(renWin)

    # Inicializa e inicia a renderização
    iren.Initialize()
    iren.Start()


if __name__ == '__main__':
    main()
